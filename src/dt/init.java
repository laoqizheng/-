package dt;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class init {
	static List<String> station_name=new ArrayList<String>();
	static List<String> lstation_name=new ArrayList<String>();
	static List<String> lline_name=new ArrayList<String>();
    static List<String> lstation_num=new ArrayList<String>();
    public static List<String> line1 = new ArrayList<String>();
    public static List<String> line2 = new ArrayList<String>();
    public static List<String> line4 = new ArrayList<String>();
    public static List<String> lineDaxing = new ArrayList<String>();
    public static List<String> line5 = new ArrayList<String>();
    public static List<String> line6 = new ArrayList<String>();
    public static List<String> line7 = new ArrayList<String>();
    public static List<String> line8bei = new ArrayList<String>();
    public static List<String> line8nan = new ArrayList<String>();
    public static List<String> line9 = new ArrayList<String>();
    public static List<String> line10 = new ArrayList<String>();
    public static List<String> line13 = new ArrayList<String>();
    public static List<String> line14xi = new ArrayList<String>();
    public static List<String> line14dong = new ArrayList<String>();
    public static List<String> line15 = new ArrayList<String>();
    public static List<String> line16 = new ArrayList<String>();
    public static List<String> lineBatong = new ArrayList<String>();
    public static List<String> lineFangshan = new ArrayList<String>();
    public static List<String> lineChangping = new ArrayList<String>();
    public static List<String> lineYizhuang = new ArrayList<String>();
    public static List<String> lineYanfang = new ArrayList<String>();
    public static List<String> lineS1 = new ArrayList<String>();
    public static List<String> lineXijiao = new ArrayList<String>();
    public static List<String> lineShoudujichang = new ArrayList<String>();
    public static Set<List<String>> lineSet = new LinkedHashSet<List<String>>();
	public static Graph graph = new Graph(400);
	public static int search(String name) {
		int i=0;
		int flag=0;
		for(i=0;i<station_name.size();i++) {
			if(name.equals(station_name.get(i))) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println(name+" "+"站点不存在");
			i=-1;
		}
		return i;
	}
	public static void searchline(String lname) {
		System.out.print(lname+"号线: ");
		int flag=0;
		switch(lname) {
    	case "1":System.out.println(line1);break;
    	case "2":System.out.println(line2);break;
    	case "4":System.out.println(line4);break;
    	case "大兴":System.out.println(lineDaxing);break;
    	case "5":System.out.println(line5);break;
    	case "6":System.out.println(line6);break;
    	case "7":System.out.println(line7);break;
    	case "8北":System.out.println(line8bei);break;
    	case "8南":System.out.println(line8nan);break;
    	case "9":System.out.println(line9);break;
    	case "10":System.out.println(line10);break;
    	case "13":System.out.println(line13);break;
    	case "14西":System.out.println(line14xi);break;
    	case "14东":System.out.println(line14dong);break;
    	case "15":System.out.println(line15);break;
    	case "16":System.out.println(line16);break;
    	case "八通":System.out.println(lineBatong);break;
    	case "房山":System.out.println(lineFangshan);break;
    	case "昌平":System.out.println(lineChangping);break;
    	case "亦庄":System.out.println(lineYizhuang);break;
    	case "燕房":System.out.println(lineYanfang);break;
    	case "S1":System.out.println(lineS1);break;
    	case "西郊":System.out.println(lineXijiao);break;
    	case "首都机场":System.out.println(lineShoudujichang);break;
    	default:System.out.println("线路不存在");break;
    	}
	}
	public static void searchstation(String sname) {
		int i=0;
		int flag=0;
		System.out.println(sname+":");
		for(List<String> line:lineSet) {
			for(String s:line) {
				if(s.equals(sname)) {
					switch(i) {
					case 0:System.out.println("1号线");flag++;break;
					case 1:System.out.println("2号线");flag++;break;
					case 2:System.out.println("4号线");flag++;break;
					case 3:System.out.println("大兴线");flag++;break;
					case 4:System.out.println("5号线");flag++;break;
					case 5:System.out.println("6号线");flag++;break;
					case 6:System.out.println("7号线");flag++;break;
					case 7:System.out.println("8号线北");flag++;break;
					case 8:System.out.println("8号线南");flag++;break;
					case 9:System.out.println("9号线");flag++;break;
					case 10:System.out.println("10号线");flag++;break;
					case 11:System.out.println("13号线");flag++;break;
					case 12:System.out.println("14号线西");flag++;break;
					case 13:System.out.println("14号线东");flag++;break;
					case 14:System.out.println("15号线");flag++;break;
					case 15:System.out.println("16号线");flag++;break;
					case 16:System.out.println("八通线");flag++;break;
					case 17:System.out.println("房山线");flag++;break;
					case 18:System.out.println("昌平线");flag++;break;
					case 19:System.out.println("亦庄线");flag++;break;
					case 20:System.out.println("燕房线");flag++;break;
					case 21:System.out.println("S1线");flag++;break;
					case 22:System.out.println("西郊线");flag++;break;
					case 23:System.out.println("首都机场线");flag++;break;
					}
				}
			}
			i++;
		}
		if(flag==0) {
			System.out.println("站点不存在");
		}
	}
	public static void init() {
		try {
            File file = new File("C:\\Users\\lqz\\Desktop\\站点名称.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
            	station_name.add(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		try {
            File file = new File("C:\\Users\\lqz\\Desktop\\站点信息.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
            	String[] sArray=line.split("\\|");
            	lstation_name.add(sArray[0]);
            	lline_name.add(sArray[1]);
            	lstation_num.add(sArray[2]);
            	switch(sArray[1]) {
            	case "1":line1.add(sArray[0]);break;
            	case "2":line2.add(sArray[0]);break;
            	case "4":line4.add(sArray[0]);break;
            	case "大兴":lineDaxing.add(sArray[0]);break;
            	case "5":line5.add(sArray[0]);break;
            	case "6":line6.add(sArray[0]);break;
            	case "7":line7.add(sArray[0]);break;
            	case "8北":line8bei.add(sArray[0]);break;
            	case "8南":line8nan.add(sArray[0]);break;
            	case "9":line9.add(sArray[0]);break;
            	case "10":line10.add(sArray[0]);break;
            	case "13":line13.add(sArray[0]);break;
            	case "14西":line14xi.add(sArray[0]);break;
            	case "14东":line14dong.add(sArray[0]);break;
            	case "15":line15.add(sArray[0]);break;
            	case "16":line16.add(sArray[0]);break;
            	case "八通":lineBatong.add(sArray[0]);break;
            	case "房山":lineFangshan.add(sArray[0]);break;
            	case "昌平":lineChangping.add(sArray[0]);break;
            	case "亦庄":lineYizhuang.add(sArray[0]);break;
            	case "燕房":lineYanfang.add(sArray[0]);break;
            	case "S1":lineS1.add(sArray[0]);break;
            	case "西郊":lineXijiao.add(sArray[0]);break;
            	case "首都机场":lineShoudujichang.add(sArray[0]);break;
            	}
                line = br.readLine();
            }
            line2.remove(18);
            line10.remove(45);
            lineShoudujichang.remove(3);
            lineSet.add(line1);
            lineSet.add(line2);
            lineSet.add(line4);
            lineSet.add(lineDaxing);
            lineSet.add(line5);
            lineSet.add(line6);
            lineSet.add(line7);
            lineSet.add(line8bei);
            lineSet.add(line8nan);
            lineSet.add(line9);
            lineSet.add(line10);
            lineSet.add(line13);
            lineSet.add(line14xi);
            lineSet.add(line14dong);
            lineSet.add(line15);
            lineSet.add(line16);
            lineSet.add(lineBatong);
            lineSet.add(lineFangshan);
            lineSet.add(lineChangping);
            lineSet.add(lineYizhuang);
            lineSet.add(lineYanfang);
            lineSet.add(lineS1);
            lineSet.add(lineXijiao);
            lineSet.add(lineShoudujichang);
        } catch (Exception e) {
            e.printStackTrace();
        }
		int size=lstation_name.size();
		for(int i=1;i<size;i++) {
			if(lline_name.get(i).equals(lline_name.get(i-1))&&Integer.parseInt(lstation_num.get(i))==Integer.parseInt(lstation_num.get(i-1))+1) {
				int x=search(lstation_name.get(i));
				int y=search(lstation_name.get(i-1));
				graph.addEdge(x, y);
			}
		}
	}
	public static void main(String[] args) {
		init();
		searchstation("苹果");
	}
}