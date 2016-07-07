package com.codepath.videotabletest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int RESULT_LOAD_VIDEO = 1;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SAMPLE DATA TEST
//        // Create sample data
//        Video sampleVideo = new Video();
//        sampleVideo.uri = "sup";
//        //sampleVideo.profilePictureUrl = "https://i.imgur.com/tGbaZCY.jpg";
//
//        //VidTag sampleVidTag = new VidTag();
//        //sampleVidTag.video = sampleVideo;
//        //sampleVidTag.label = "Won won!";
//        //sampleVidTag.time = 1;
//
//        // Get singleton instance of database
//        PostsDatabaseHelper databaseHelper = PostsDatabaseHelper.getInstance(this);
//        databaseHelper.addOrUpdateVideo(sampleVideo);
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
