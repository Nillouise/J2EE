import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "UploadPhotoServlet",urlPatterns = {"/uploadPhoto"})
public class UploadPhotoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //handnote 处理 上传文件 的servlet
        //这里应该是在response里收到了所有的信息，然后根据name来取得收到文件的那段信息，然后写入硬盘的文件
        //这里的限制大小只是限制了硬盘文件的大小，根本没有检查response里文件本身的大小

        String filename = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为1M
            factory.setSizeThreshold(1024 * 1024);

            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {

                    // 根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".jpg";
                    //handnote
                    //设置web文件夹下的资源，在idea的调试里，是会先将web项目部署到out文件夹里，然后一切资源的调取都是在out文件夹里（而不是在本module文件夹内），
                    // 这是因为idea把tomcat外链到out文件夹，所以一切资源的调取都在out文件夹内。
                    //但这里我没找到方法取得这个生成项目在out文件夹的哪里，所以就硬写了上去。
                    String photoFolder = "C:\\Users\\win7x64\\IdeaProjects\\J2EE\\out\\artifacts\\ServeletBigProject_war_exploded\\resources\\uploaded";
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    System.out.println(f.getParentFile().getAbsolutePath() );

                    // 通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();

                    // 复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();

                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                    System.out.println(value);
                }
            }

            //这里也是外链到out文件夹内。
            String html = "<img width='200' height='150' src='resources\\uploaded/%s' />";
            response.setContentType("text/html");
            PrintWriter pw= response.getWriter();

            pw.format(html, filename);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}