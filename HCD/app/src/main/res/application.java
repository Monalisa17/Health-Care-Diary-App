import com.parse.Parse;
import
/**
 * Created by Britt-Britt on 10/27/2015.
 */
public class application extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "9lsXvAhxazTezFl8oTEhCnGr3p9S0qNetMNgmmgR", "ZYWsX8HmLCoEBFkfwZuPljn2VNiaqDomcMbkFIrk");
    }

}
