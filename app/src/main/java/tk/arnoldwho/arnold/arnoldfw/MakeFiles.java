package tk.arnoldwho.arnold.arnoldfw;

import java.io.DataOutputStream;
import java.io.File;

/**
 * Created by arnold on 2018/1/28.
 */

public class MakeFiles {
    private String str = "/data/system/ifw/" + AppBaseAdapter.APPName + ".xml";

    public Boolean Check(String files) {

        try {
            File file = new File(files);
            if (!file.exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean Make() {
        if (Check(str)) {
            return false;
        }
        else{
            Process process = null;
            DataOutputStream os = null;
            try {
                String cmd = "su -c touch " + str;
                process = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(process.getOutputStream());
                os.writeBytes(cmd + "\n");
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
            }
            catch (Exception e) {
                return false;
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                    process.destroy();
                } catch (Exception e) {
                }
            }
            return true;
        }
    }
}
