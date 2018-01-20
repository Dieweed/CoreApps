package pago.casa.dhuerta.project.casapago;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dhuerta on 13/01/2018.
 */

public class NetServices extends AsyncTask<String, Void, Object> {

    private static final String URLWS1 = "http://espaciofinvivir.com/pmo/index.php/Familia/cnsVotoDireccion";
    private OnTaskCompleted listener;
    private Exception exception;

    public NetServices(OnTaskCompleted listener)
    {
        exception = null;
        this.listener = listener;
    };

    private static String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;

        try{
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }catch(IOException ex)
        {
            ex.printStackTrace();
        }finally {
            try{
                is.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    @Override
    protected Object doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Object feed) {
        if(exception == null)
        {
            listener.onTaskCompleted(feed);
        }else{
            listener.onTaskError(exception.toString());
        }
    }
}
