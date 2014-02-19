import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Miguel on 19/02/14.
 */
public class timestamp
{
    public static void main (String args[])
    {
        System.out.println("timestamp: " + timestamp());
    }

    public static long timestamp()
    {
        long VLlngDatos = 0;

        DateFormat VLobjFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S G");

        String VLstrFecha1 = "4713/01/01 12:00:00.0 BC";
        //String VLstrFecha2 = "2014/02/18 00:00:00.0 AD";

        Date VLdateInicio = null;
        Date VLdateFinal = null;

        try
        {
            VLdateInicio = VLobjFormat.parse(VLstrFecha1);
            //VLdateFinal = VLobjFormat.parse(VLstrFecha2);
            VLdateFinal = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTime();
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }

        VLlngDatos = VLdateFinal.getTime() - VLdateInicio.getTime();
        if (String.valueOf(VLlngDatos).length() < 18)
        {
            String VLstrValor = String.valueOf(VLlngDatos);
            int VLintNumero = 18 - VLstrValor.length();
            for (int i = 0; i < VLintNumero; i++)
            {
                VLstrValor += "0";
            }
            VLlngDatos = Long.parseLong(VLstrValor);
        }
        return  VLlngDatos;
    }
}
