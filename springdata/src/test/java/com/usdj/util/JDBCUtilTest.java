package com.usdj.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author gerrydeng
 * @date 2019-07-25 09:54
 * @Description:
 */
public class JDBCUtilTest {

    @Test
    public void testConnection() throws SQLException, IOException, ClassNotFoundException {
        Assert.assertNotNull(JDBCUtil.getConnection());
    }

}