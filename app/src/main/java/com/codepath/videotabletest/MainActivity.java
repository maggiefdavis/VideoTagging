package com.codepath.videotabletest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static int RESULT_LOAD_VIDEO = 1;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SAMPLE DATA TEST
//        // Create sample data
        Video sampleVideo1 = new Video();
        sampleVideo1.uri = "special1";

        Video sampleVideo2 = new Video();
        sampleVideo2.uri = "sup";

        Video sampleVideo3 = new Video();
        sampleVideo3.uri = "special2";
//
        VidTag sampleVidTag1 = new VidTag();
        sampleVidTag1.video = sampleVideo1;
        sampleVidTag1.label = "One!";
        sampleVidTag1.time = 1;

        VidTag sampleVidTag2 = new VidTag();
        sampleVidTag2.video = sampleVideo2;
        sampleVidTag2.label = "Two!";
        sampleVidTag2.time = 2;

        VidTag sampleVidTag3 = new VidTag();
        sampleVidTag3.video = sampleVideo3;
        sampleVidTag3.label = "One!";
        sampleVidTag3.time = 3;

        VidTag sampleVidTag4 = new VidTag();
        sampleVidTag4.video = sampleVideo1;
        sampleVidTag4.label = "Four!!";
        sampleVidTag4.time = 4;

//        // Get singleton instance of database
        VidTagsDatabaseHelper databaseHelper = VidTagsDatabaseHelper.getInstance(this);
        databaseHelper.deleteAllVidTagsAndVideos();
        databaseHelper.addOrUpdateVideo(sampleVideo1);
        databaseHelper.addOrUpdateVideo(sampleVideo2);
        databaseHelper.addOrUpdateVideo(sampleVideo3);
        databaseHelper.addVidTag(sampleVidTag1);
        databaseHelper.addVidTag(sampleVidTag2);
        databaseHelper.addVidTag(sampleVidTag3);
        databaseHelper.addVidTag(sampleVidTag4);
        databaseHelper.deleteVideo(sampleVideo3);
        Set<Video> results = databaseHelper.getSearchResults("One!");
        Log.d("DEBUG", "size of results set: " + Integer.toString(results.size()));
        for (Video video: results) {
            Log.d("DEBUG", "video uri: " + video.uri);
        }

       Log.d("DEBUG", Integer.toString(databaseHelper.getVideoID(sampleVideo2.uri)));
        List<VidTag> vidTags = databaseHelper.getAllVidTags();
        for (int i = 0; i < vidTags.size(); i++) {
            Log.d("DEBUG","vidTag labels: " + vidTags.get(i).label);

       }
        int id1 = databaseHelper.getVidTagId(sampleVidTag1);
        Log.d("DEBUG", "vidtag1 id: " + Integer.toString(id1));
        int id2 = databaseHelper.getVidTagId(sampleVidTag2);
        Log.d("DEBUG", "vidtag2 id: " + Integer.toString(id2));
        Log.d("DEBUG", "hi");

        //Toast.makeText(this)
        //databaseHelper.getVideo();
//
//        // Add sample post to the database
//        //databaseHelper.addVidTag(sampleVidTag);
//
//        // Get all posts from database
//        List<VidTag> vidTags = databaseHelper.getAllVidTags();
//        for (VidTag vidTag : vidTags) {
//            TextView tvVidTag = (TextView) findViewById(R.id.tvVidTag);
//            tvVidTag.setText(Integer.toString((vidTag.time)));
//            // do something
//
//        }
//        databaseHelper.deleteVideo(sampleVideo);
//
//        List<Video> videos = databaseHelper.getAllVideos();
//        if (videos.isEmpty()) {
//            Log.d("DEBUG", "Empty");
//        }
//        else {
//            Log.d("DEBUG", "not empty");
//        }
//        for (Video video : videos) {
//            TextView tvVidTag = (TextView) findViewById(R.id.tvVidTag);
//            tvVidTag.setText(video.uri);
//            // do something
//
//        }
    }


    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        //android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_VIDEO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_VIDEO && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                //Video video = new Video(selectedImage.toString());
//                String[] filePathColumn = { MediaStore.Video.Media.DATA };
//
//                // Get the cursor
//                Cursor cursor = getContentResolver().query(selectedImage,
//                        filePathColumn, null, null, null);
//                // Move to first row
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                imgDecodableString = cursor.getString(columnIndex);
//                cursor.close();
//                final VideoView vidView = (VideoView) findViewById(R.id.video_view);
//                //ImageView imgView = (ImageView) findViewById(R.id.imgView);
//                //vidView.setVideoPath(imgDecodableString);
//                vidView.setVideoURI(selectedImage);

//                Log.d("URI", selectedImage.toString());
//                vidView.start();
                // Set the Image in ImageView after decoding the String
//                imgView.setImageBitmap(BitmapFactory
//                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }
}
