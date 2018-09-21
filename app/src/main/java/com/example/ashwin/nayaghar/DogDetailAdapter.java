package com.example.ashwin.nayaghar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashwin on 2/5/2017.
 */
public class DogDetailAdapter extends AppCompatActivity {
    TextView dog_adoptdetail_name = (TextView) findViewById(R.id.dog_adoptdetail_name);
    TextView dog_adoptdetail_age = (TextView) findViewById(R.id.dog_adoptdetail_age);
    TextView dog_adoptdetail_gender = (TextView) findViewById(R.id.dog_adoptdetail_gender);
    TextView dog_adoptdetail_vac = (TextView) findViewById(R.id.dog_adoptdetail_vac);
    TextView dog_adoptdetail_description = (TextView) findViewById(R.id.dog_adoptdetail_description);
    TextView dog_adoptdetail_Breed = (TextView) findViewById(R.id.dog_adoptdetail_Breed);
    ImageView PHOTO;

    Context context;
    ArrayList<AdoptionModel> dogList = new ArrayList<>();
    public DogDetailAdapter(Context context, ArrayList<AdoptionModel> dogList) {

            this.context = context;
            this.dogList = dogList;

    }



    public DogListView onCreateViewHolder(ViewGroup parent, int viewType) {

        return new DogListView(LayoutInflater.from(context).inflate(R.layout.activity_dog_adoptdetail, parent, false));
    }


    public void onBindViewHolder(DogListView holder, int position) {

        AdoptionModel d = dogList.get(position);
        holder.name.setText(d.getDogName());
        holder.age.setText(d.getDogAge());
        holder.vac.setText(d.getDogVac());
        holder.description.setText(d.getDogDescription());
        holder.Breed.setText(d.getDogBreed());
        holder.gender.setText(d.getDogGender());


        byte[] decodedString = Base64.decode(d.getDogPic(), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.photo.setImageBitmap(bitmap);

//        holder.photo.setImageBitmap(d.getDogPic());
    }


    public int getItemCount() {
        return dogList.size();
    }

    class DogListView extends RecyclerView.ViewHolder {

        public ImageView photo;
        public TextView name;
        public TextView age ;
        public TextView gender ;
        public TextView vac ;
        public  TextView description;
        public  TextView Breed;

        public DogListView(View itemView) {
            super(itemView);

            photo = (ImageView) itemView.findViewById(R.id.grid_dog_photo);
            name = (TextView) itemView.findViewById(R.id.dog_adoptdetail_name);
            age = (TextView) itemView.findViewById(R.id.dog_adoptdetail_age);
            gender = (TextView) itemView.findViewById(R.id.dog_adoptdetail_gender);
            vac = (TextView) itemView.findViewById(R.id.dog_adoptdetail_vac);
            description = (TextView) itemView.findViewById(R.id.dog_adoptdetail_description);
            Breed = (TextView) itemView.findViewById(R.id.dog_adoptdetail_Breed);



        }
    }


}
