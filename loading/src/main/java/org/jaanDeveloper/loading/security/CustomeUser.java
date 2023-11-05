package org.jaanDeveloper.loading.security;

import org.jaanDeveloper.loading.model.UserRegister;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


public class CustomeUser implements UserDetails  {
    private UserRegister userRegister;

    public CustomeUser() {
    }

    public CustomeUser(UserRegister userRegiste) {
        this.userRegister = userRegiste;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userRegister.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {

        return userRegister.getPassword();
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return userRegister.getUsername();
    }
    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails shiv= User.builder()
                .username("shiv")
                .password("{noop}shiv")
                .roles("HR")
                .build();

        UserDetails shivjay= User.builder()
                .username("shivjay")
                .password("{noop}shivjay")
                .roles("HR","ADMIN")
                .build();

        UserDetails jaan= User.builder()
                .username("jaan")
                .password("{noop}jaan")
                .roles("TRACKER")
                .build();
String pass="laxman";
        UserDetails laxman= User.builder()
                .username("laxman")
                .password("{noop}"+pass)
                .roles("TRACKER")
                .build();

        return new InMemoryUserDetailsManager(shiv,shivjay,jaan,laxman);
    }*/

}