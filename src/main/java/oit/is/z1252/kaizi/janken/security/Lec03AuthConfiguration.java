package oit.is.z1252.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Lec03AuthConfiguration
 */
@Configuration
@EnableWebSecurity
public class Lec03AuthConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * 誰がログインできるか(認証処理)
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("user1")
        .password("$2y$10$d8nU4IjAH0km6DbfYfgjMe2.NBwUIv8lXP1p4/tzsnYJlD8kMdIoa").roles("USER");
    auth.inMemoryAuthentication().withUser("admin")
        .password("$2y$10$HyEv7jcuGKBQfoEl1yrw1Oylq8ep/IdUatiG5VN5YZedIv6gABGgG").roles("USER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * 認証されたユーザがどこにアクセスできるか（認可処理）
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // Spring Securityのフォームを利用してログインを行う
    http.formLogin();

    http.authorizeRequests().antMatchers("/lec02/**").authenticated();

    // Spring Securityの機能を利用してログアウト．ログアウト時は http://localhost:8000/ に戻る
    http.logout().logoutSuccessUrl("/");
  }

}
