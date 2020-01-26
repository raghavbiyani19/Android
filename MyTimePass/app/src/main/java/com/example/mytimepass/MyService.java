package com.example.mytimepass;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MyService extends Service {

    @Override public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override public int onStartCommand(Intent intent, int flags, int startId) {
         Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
         try {
             new DoBackgroundTask().execute(new URL("http://www.amazon.com/somefiles.pdf"),
                     new URL("http://www.wrox.com/somefiles.pdf"),
                     new URL("http://www.google.com/somefiles.pdf"),
                     new URL("http://www.learn2develop.net/somefiles.pdf"));
         } catch (MalformedURLException e)
         {
             e.printStackTrace();
         }
         return START_STICKY;
    }


    @Override public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Service Destroyed", Toast.LENGTH_LONG).show();
    }

    private class DoBackgroundTask extends AsyncTask<URL, Integer, Long> {
        protected Long doInBackground(URL... urls)
        {
            int count = urls.length;
            long totalBytesDownloaded = 0;
            for (int i = 0; i < count; i++)
            {
                totalBytesDownloaded += DownloadFile(urls[i]);
                publishProgress((int) (((i+1) / (float) count) * 100));
            }
            return totalBytesDownloaded;
        }

        protected void onProgressUpdate(Integer... progress)
        {
            Log.d("Downloading files", String.valueOf(progress[0]) + "% downloaded");
            Toast.makeText(getBaseContext(), String.valueOf(progress[0]) + "% downloaded", Toast.LENGTH_LONG).show();
        }

        protected void onPostExecute(Long result)
        {
            Toast.makeText(getBaseContext(), "Downloaded " + result +"bytes", Toast.LENGTH_LONG).show();
            stopSelf();
        }

        private int DownloadFile(URL url)
        {
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return 100;
        }

    }
}