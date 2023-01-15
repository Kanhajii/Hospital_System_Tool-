package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Spacalist;

public class SpacialistDao {
	
	private Connection conn;

	public SpacialistDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	public boolean addSpacialist(String spec)
	{
		boolean f=false;
		try {
			String sql = "insert into spacialist(spec_name)values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, spec);
			
			int i=ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}
	
	public List<Spacalist> getAllSpacalist()
	{
		List<Spacalist> list= new ArrayList<Spacalist>();
		Spacalist s = null;
		
		try {
			String sql="select * from Spacialist";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				s=new Spacalist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
 	
}
