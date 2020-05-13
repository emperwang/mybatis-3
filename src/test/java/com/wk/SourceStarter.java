package com.wk;

import com.wk.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class SourceStarter {

  @Test
  public void sources() throws IOException {
    SqlSessionFactory sessionFactory;
    Reader reader = Resources.getResourceAsReader("MyBatis-config.xml");
    sessionFactory = new SqlSessionFactoryBuilder().build(reader);
    SqlSession sqlSession = sessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User user = mapper.selectById(1);
    System.out.println(user);
  }
}
