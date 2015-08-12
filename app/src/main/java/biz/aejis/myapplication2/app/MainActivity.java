package biz.aejis.myapplication2.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class MainActivity extends ActionBarActivity {


    public void test() {
        final VideoView mVideoView = (VideoView)findViewById(R.id.video_view);

        //Setting video path(url)
        mVideoView.setVideoPath("https://player.ooyala.com/player/ipad/VzNnlpdjrHUQh4MPyPqVJ0Mtp_Yaxa-1.m3u8");

        //Setting main focus on video view
        mVideoView.requestFocus();
        mVideoView.start();

        //Initializing the video player’s media controller.
        MediaController controller = new MediaController(this);

        //Binding media controller with VideoView

        mVideoView.setMediaController(controller);

        //Registering a callback to be invoked when the media file is loaded and ready to go.
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer arg0) {
                //Starting the player after getting information from url.
                mVideoView.start();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        test();
    }
}
