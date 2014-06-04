/*
Copyright (C) April 2014 Mehboub Sophian

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License along
with this program; if not, write to the Free Software Foundation, Inc.,
51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package com.interim.util;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.text.html.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class WebPagePrinter {
private BufferedImage image = null;

public BufferedImage Download(String webpageurl,final String output) {
try
{
    URL url = new URL(webpageurl);
    final JEditorPane jep = new JEditorPane(url);
    jep.setEditable(false);
    jep.setBounds(0,0,1500,2048);
    jep.addPropertyChangeListener("page",new
    PropertyChangeListener() {
                @Override
    public void propertyChange(PropertyChangeEvent e) {
    try
    {
        image = new
        BufferedImage(1500,2048,BufferedImage.TYPE_INT_RGB );
        Graphics g = image.getGraphics();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        jep.paint(graphics);
        ImageIO.write(image,"png",new File(output));
    }
    catch (Exception re)
    {
        re.printStackTrace();
    }
    }});
    jep.setPage(url);

}
catch (Exception e)
{
e.printStackTrace();
}
return image;
}

    public static void main(String[] args) {

       // new WebPagePrinter().Download("https://www.leforem.be/HotJob/servlet/JobOffs.View?id=16375876&nextUrl=", "D:/webpage.png");

    }
}