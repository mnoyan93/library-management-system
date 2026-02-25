package com.example.librarymanagementsystem.service.sequrity;

import com.example.librarymanagementsystem.model.Users;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Objects;


//spring-ի user ն է ;կվերցնենք իրա կոնստրուկտորներից մեկը(username,password,authorities,բայց կուտանք մեր users -ը)
public class SpringUser extends org.springframework.security.core.userdetails.User{
    @Getter
private Users users;

    public SpringUser(Users users) {
        super(users.getUsername(),
                users.getPassword(),
                AuthorityUtils.createAuthorityList(users.getRole().name()));
        this.users=users;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpringUser that = (SpringUser) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), users);
    }


//
//    public Users getUser() {
//return users;
//    }
//ու այս users ը տալիս ենք UsersDetailsServiceImpl -ին return ի ժամանակ;
}
