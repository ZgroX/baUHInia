package pl.ioad1.bauhinia.elementeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elementeditor.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ElementCreator extends AppCompatActivity {
    private boolean elementChange = true;
    private Element element = null;
    private static int RESULT_LOAD_IMAGE = 1;
    private TextView name,height,width,length,transparent;
    private Button saveBtn, loadImageBtn;
    private ElementEditorCommunicator elementEditorCommunicator;
    public static final int GALLERY_REQUEST = 1;
    private ImageView mSelectImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element_creator);
        elementEditorCommunicator =new ElementEditorCommunicator();
        name = findViewById(R.id.nameEditField);
        height = findViewById(R.id.heigthEditField);
        width = findViewById(R.id.widthEditField);
        length = findViewById(R.id.lengthEditField);
        transparent = findViewById(R.id.transparentEditField);
        saveBtn = findViewById(R.id.saveBtn);
        loadImageBtn = findViewById(R.id.setImageBtn);
        mSelectImage = findViewById(R.id.imageView);
        Bundle b = getIntent().getExtras();
        if(b != null){
            int tmp;
            tmp = (int) b.get("element_to_edit");
            element = new Element(elementEditorCommunicator.getElementById(tmp));
            showActualValues();
            elementChange = true;
        }
        else {
            element = new Element();
            elementChange = false;
        }
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              saveElement();
            }
        });
        loadImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setImage();
            }
        });
        if(element.getImage() != null){
            mSelectImage.setImageBitmap(element.getImage());
        }

    }
    void saveElement(){
        element.setId(elementEditorCommunicator.generateId());
        if((name.getText().toString()=="")||(height.getText().toString()=="")||(length.getText().toString()=="")||(width.getText().toString()=="")||(transparent.getText().toString()=="")){
            showInformation("All field must be completed.");
            return;
        }
        setName(name.getText().toString());
        setHeigth(Float.parseFloat(height.getText().toString()));
        setLength(Integer.parseInt(length.getText().toString()));
        setWidth(Integer.parseInt(width.getText().toString()));
        setTransparent(Float.parseFloat(transparent.getText().toString()));
        if(elementEditorCommunicator.getElementById(element.getId())!=null){
            showInformation("Sucesfully saved element:\n"+elementEditorCommunicator.getElementById(element.getId()).toString());
            finish();
        }else{
            showInformation("Something goes wrong with saving element, please try again... :(");
        }
        if(elementChange)
            elementEditorCommunicator.saveElementChange(element);
        else
            elementEditorCommunicator.addElement(element);
    }
    void setName(String name){
        element.setName(name);
    }
    void setHeigth(float height){
        element.setHeight(height);
    }
    void setLength(int length){
        if((length<=0)||(length>50)){
            showInformation("Length value is wrong.\nMust be lower than 50 and greater than 0. ");
            return;
        }
        element.setLength(length);
    }
    void setWidth(int width){
        if((width<=0)||(width>50)){
            showInformation("Width value is wrong.\nMust be lower than 50 and greater than 0. ");
            return;
        }
        element.setWidth(width);
    }
    void setImage(){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    void setTransparent(float transparent){
        if((transparent<0)||(transparent>1)) {
            showInformation("Transparent value is wrong.\nMust be lower than 1 and greater than 0. ");
            return;
        }
        element.setTransparent(transparent);
    }
    private void showInformation(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showActualValues(){

        if(element!=null){
            name.setText(element.getName());
            height.setText(Float.toString(element.getHeight()));
            width.setText(Integer.toString(element.getWidth()));
            length.setText(Integer.toString(element.getLength()));
            transparent.setText(Float.toString(element.getTransparent()));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){

            Uri imageUri = data.getData();
            Bitmap bm = null;
            try {
                bm = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
            } catch (IOException e) {
                showInformation("Can't load image because:\n"+e.getMessage());
                return;
            }

            element.setImage(bm);
            mSelectImage.setImageBitmap(element.getImage());

        }
    }
}
