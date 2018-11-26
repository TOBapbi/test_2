package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Bean.CouBean;
import Conn.Conn;



public class Cou {
	

	@SuppressWarnings("static-access")
	public Iterator<CouBean> selectCou(){
		List<CouBean> list = null;
		Iterator<CouBean> listall = null;
		try{Connection conn=null;
			 conn = new Conn().connect();
			PreparedStatement pst = conn.prepareStatement("select * from course");
			ResultSet rs = pst.executeQuery();
			list = new ArrayList<CouBean>();
			while(rs.next()){				
				CouBean cou = new CouBean(rs.getInt("couid"),rs.getString("couname"),rs.getInt("coutimes"),rs.getString("couroom"),rs.getString("coutea"));
				list.add(cou);
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}

}
