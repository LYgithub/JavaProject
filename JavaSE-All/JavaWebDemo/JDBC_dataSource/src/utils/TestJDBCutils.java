package utils;

import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: utils
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class TestJDBCutils {
    @Test
    public void testJDBCutils(){
        /**
         * 插入一条数据
         */
        Connection con = null;
        PreparedStatement pstam = null;
        try{
            con = JDBCutils.getConn();
            String sql = "insert into student values (?,?,?)";
            pstam = con.prepareStatement(sql);
            pstam.setInt(1, 12);
            pstam.setDouble(2, 98.90);
            pstam.setString(3,"1997-02-12");
            int i = pstam.executeUpdate();
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCutils.close(pstam, con);
        }

    }
}
