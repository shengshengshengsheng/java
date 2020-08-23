package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author:Administrator
 * @date:2020/8/23
 * @description:
 */
public class UserDaoImpl implements IUserDao{
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return userList;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, user.getBirthday(), null, user.getUsername(),
                user.getPassword(), user.getSex(), user.getAddress(), user.getAge(), user.getQq(), user.getEmail());
        System.out.println("更新的条数:"+update);
    }

    @Override
    public User findUserByUserNameAndPassWord(User user) {
        String sql="select * from user where username =? and password =?";
        try{
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
        }catch (Exception e){
            return null;
        }
    }
}
