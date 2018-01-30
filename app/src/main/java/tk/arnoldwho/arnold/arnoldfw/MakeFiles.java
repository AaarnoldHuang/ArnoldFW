package tk.arnoldwho.arnold.arnoldfw;

import java.io.DataOutputStream;

/**
 * Created by arnold on 2018/1/28.
 */

public class MakeFiles {
    private String cmd;
    public Boolean Make(int i) {
            Process process = null;
            DataOutputStream os = null;
            try {
                if (i == 1){
                    cmd = "su -c /data/ifw.sh -a " + AppBaseAdapter.APPName + ".xml \"" + ShowActivitiesActivity.string + "\"";
                }
                else if (i == 2){
                    cmd = "su -c /data/ifw.sh -b " + AppBaseAdapter.APPName + ".xml \"" + ShowActivitiesActivity.string + "\"";
                }
                process = Runtime.getRuntime().exec(cmd);
                os = new DataOutputStream(process.getOutputStream());
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
