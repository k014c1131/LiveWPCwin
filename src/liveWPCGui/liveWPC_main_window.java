package liveWPCGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class liveWPC_main_window extends liveWPC_window_base{
	private static JPanel panel = new JPanel();
	private static JPanel border = new JPanel();
	private liveWPC_tool_window tool_window;
	private liveWPC_proprety_window proprety_window;
	//private liveWPC_create_object tc;
	//private static Graphics g;
	private static ArrayList<liveWPC_create_object> list= new ArrayList<liveWPC_create_object>();

	liveWPC_main_window(){
		//tool_window= new liveWPC_tool_window();
		//proprety_window = new liveWPC_proprety_window();
		//proprety_window.call_proprety_window(1);//数字を変更することで表示する内容を変える。
		//proprety_window.call_proprety_window(0);

		panel.setPreferredSize(new Dimension(750,480));
		panel.setLayout(null);
		panel.setLocation(FlowLayout.CENTER,200);
		panel.setBackground(Color.WHITE);
		panel.setVisible(true);

		border.setOpaque(false);
		LineBorder bordercolor = new LineBorder(Color.BLACK, 2, true);
		border.setBorder(bordercolor);
		border.setVisible(true);
		border.setSize(225,400);
		border.setLocation(262,0);

		panel.add(border);
		getContentPane().add(panel);




		setSize(750,480);
		setLocationRelativeTo(null);
		//proprety_window.change_text_size_box(false);
		//proprety_window.change_font_type_box(false);

	}

	/*@Override
	public void paint(Graphics g){//現在使用していない
		border.setLocation(262, 0);
		super.paint(g);
	}*/

	public  void insert_image(String imagepath){
		liveWPC_create_image_object tc = new liveWPC_create_image_object(imagepath);
		panel.add(tc);
		tc.setLocation(50, 50);
		list.add(tc);
	}
	public  void insert_image(String imagepath,int x,int y,int width,int height){
		liveWPC_create_image_object tc = new liveWPC_create_image_object(imagepath,width,height);
		panel.add(tc);
		tc.setLocation(x, y);
		list.add(tc);
	}

	public  void insert_text(){
	liveWPC_create_text_object tc = new liveWPC_create_text_object(proprety_window);
	panel.add(tc);
	tc.setLocation(50, 50);
	list.add(tc);
	//panel.removeAll();
	//panel.repaint();
	}
	public  void insert_text(int x,int y,int width,int height,String text){
		liveWPC_create_text_object tc = new liveWPC_create_text_object(width, height, text);
		panel.add(tc);
		tc.setLocation(x, y);
		list.add(tc);
		}
	public ArrayList<liveWPC_create_object> getList(){
		return list;
	}
	public void removeAllObject(){
		panel.removeAll();
		panel.add(border);
		panel.repaint();
	}
	public void removeObject(liveWPC_create_object obj){
		//panel.removeAll();
		panel.remove(obj);
		panel.repaint();
	}

	public void setWindow(liveWPC_tool_window tool_window,liveWPC_proprety_window proprety_window){
		this.tool_window=tool_window;
		this.proprety_window=proprety_window;
		this.addKeyListener(proprety_window);//ここで削除処理をプロパティから借りている
		}
}



