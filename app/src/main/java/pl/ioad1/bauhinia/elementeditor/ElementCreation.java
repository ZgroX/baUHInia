package pl.ioad1.bauhinia.elementeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import pl.ioad1.bauhinia.R;

import java.util.ArrayList;


public class ElementCreation extends AppCompatActivity {
    private ArrayList<Element> elements;
    private ElementEditorCommunicator elementEditorCommunicator;
    private TableLayout table;
    private Button addElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_creation);
        table = findViewById(R.id.elementTable);
        addElement = findViewById(R.id.addElement);
        elementEditorCommunicator = new ElementEditorCommunicator();
        elements = new ArrayList<>();
        refreshList();
        addElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addElement();
            }
        });

    }

    private void editElement(Element element){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to edit element named:\n"+element.getName());
        builder. setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startElementCreatorActivity(element);
            }
        });
        builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
   private void refreshList() {
        while(table.getChildCount()>1)
            table.removeViewAt(table.getChildCount()-1);
        elements.clear();
        elements.addAll(elementEditorCommunicator.dowloadList());
        for (Element element : elements)
            addRowToTable(element);

    }
    private void addRowToTable(Element element){
        TableRow row = new TableRow(this);
        TextView name = new TextView(this);
        TextView edit = new TextView(this);
        ImageView image = new ImageView(this);
        image.setPadding(10,5,10,5);
        if(element.getImage()==null)
            image.setImageResource(R.drawable.loading_error);
        else
            image.setImageBitmap(element.getImage());
        edit.setPadding(10,5,10,5);
        name.setPadding(10,5,10,5);
        edit.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        edit.setText("edit");
        edit.setTextColor(Color.BLUE);
        edit.setClickable(true);
        name.setText(element.getName());
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editElement(element);
            }
        });
        image.setMaxHeight(60);
        image.setMaxWidth(60);
        image.setAdjustViewBounds(true);
        row.addView(image);
        row.addView(name);
        row.addView(edit);
        table.addView(row);
    }

    private void addElement(){
        Intent intent = new Intent(this,ElementCreator.class);
        startActivity(intent);
    }

    private void startElementCreatorActivity(Element element){
        Intent intent = new Intent(this,ElementCreator.class);
        intent.putExtra("element_to_edit", element.getId());
        startActivity(intent);
    }
}