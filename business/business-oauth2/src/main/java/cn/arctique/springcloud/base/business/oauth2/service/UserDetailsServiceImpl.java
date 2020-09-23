package cn.arctique.springcloud.base.business.oauth2.service;

import cn.arctique.springcloud.base.common.util.JsonUtil;
import cn.arctique.springcloud.base.user.provider.api.service.UserService;
import com.google.common.collect.Lists;
import cn.arctique.springcloud.base.user.provider.api.pojo.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author arctique
 * @date 2020/9/17 12:28
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 权限
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);

        // 用户信息
        User user = userService.findOne(username);
        System.out.println(JsonUtil.toJson(user));

        // 判断用户名
        return user != null
                ? new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities)
                : null;
    }
}
