
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabo Quesada
 */
public class DAOImpl implements DAO {

    private Model model;
    private BufferedReader reader = null;
    private BufferedWriter bufferedWriter = null;
    private OutputStream outputStream = null;
    private StringBuilder requestresult = null;
    private HttpURLConnection connection = null;
    private InputStream stream = null;
    private URL url;
    private StringBuffer buffer = null;

    public DAOImpl() {
    }

    public DAOImpl(Model model) {
        this.model = model;
    }

    @Override
    public String setPost(Model model) {

        try {
          
            url = new URL(model.getServer());
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000);
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.connect();

            outputStream = connection.getOutputStream();
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            requestresult = new StringBuilder();
            
            requestresult.append("&nombre=");
            requestresult.append(URLEncoder.encode(model.getNombre(), "UTF-8"));
            requestresult.append("&edad=");
            requestresult.append(URLEncoder.encode(model.getEdad(), "UTF-8"));
            
            bufferedWriter.write(requestresult.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
             
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            
            while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
            
            return buffer.toString();
             
        } catch (MalformedURLException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        
     return null;
    }

}
