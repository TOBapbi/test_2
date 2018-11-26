package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Bean.CouSelect;
import Bean.SC;
import Conn.Conn;


public class ScDao {
  
	
	
	@SuppressWarnings("static-access")
	public int[] insertSc(SC sc[]){
		int[] rs = null;
		try{
			String sql = "insert into selectcourse(id,couid) values(?,?)";
			Connection conn=null;
			 conn = new Conn().connect();
			PreparedStatement pst = conn.prepareStatement(sql);
			SC tem = null;
			rs = new int[sc.length];
			for(int i = 0;i< sc.length;i++){
				tem = sc[i];
				pst.setInt(1, tem.getId());
				pst.setInt(2, tem.getCouid());
				rs[i] = pst.executeUpdate();
			}
			
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
	
	@SuppressWarnings("static-access")
	public Iterator<CouSelect> selectSc(int id){
		Iterator<CouSelect> listall = null;
		CouSelect cou = null;
		try{
			List<CouSelect> list  = new ArrayList<CouSelect>();
			String sql = "select * from course,selectcourse "
					+ "where course.couid=selectcourse.couid and id=?;";
			Connection conn=null;
			 conn = new Conn().connect();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				cou = new CouSelect();
				cou.setCouid(rs.getInt("couid"));
				cou.setCouname(rs.getString("couname"));
				cou.setCoutimes(rs.getInt("coutimes"));
				cou.setCouroom(rs.getString("Couroom"));
				cou.setCoutea(rs.getString("Coutea"));
				list.add(cou);
				System.out.println("selected course is over!!");
			}
			listall = list.iterator();
		}catch(Exception e){e.printStackTrace();}
		return listall;
	}
	
	@SuppressWarnings("static-access")
	public int deleteSc(int id,int couid){
		int rs = 0;
		try{
			String sql = "delete from selectcourse where id=? and couid=?";
			Connection conn=null;
			 conn = new Conn().connect();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, couid);
			rs = pst.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
		return rs;
	}
}
