package com.repository;

import com.domain.UserAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAccountRepositoryTest {
    @Autowired
    UserAccountRepository repository;

    @Test
    public void shouldReturnIdEtc() {
        UserAccount user = repository.save(UserAccount.builder().login("DK").password("qwer").accountName("Kras")
                .addressRegion("Wielkopolska").addressCity("Poznan").addressStreet("Katowicka")
                .accountCreateDate("17.07.2018").accountStatus("active").accountTypePremium(true).build());

        Optional<UserAccount> byId = repository.findById(5L);

        assertThat(user.getId()).isEqualTo(byId.get().getId());
        assertThat(user.getLogin()).isEqualTo(byId.get().getLogin());
        assertThat(user.getPassword()).isEqualTo(byId.get().getPassword());
        assertThat(user.getAccountName()).isEqualTo(byId.get().getAccountName());
        assertThat(user.getAddressRegion()).isEqualTo(byId.get().getAddressRegion());
        assertThat(user.getAddressCity()).isEqualTo(byId.get().getAddressCity());
        assertThat(user.getAddressStreet()).isEqualTo(byId.get().getAddressStreet());
        assertThat(user.getAccountCreateDate()).isEqualTo(byId.get().getAccountCreateDate());
        assertThat(user.getAccountStatus()).isEqualTo(byId.get().getAccountStatus());
    }

    @Test
    public void shouldNotReturnIdEtc() {
        UserAccount user = repository.save(UserAccount.builder().login("DK").password("qwer").accountName("Kras")
                .addressRegion("Wielkopolska").addressCity("Poznan").addressStreet("Katowicka")
                .accountCreateDate("17.07.2018").accountStatus("active").accountTypePremium(true).build());

        Optional<UserAccount> byId = repository.findById(4L);

        assertThat(user.getId()).isNotEqualTo(byId.get().getId());
        assertThat(user.getLogin()).isNotEqualTo(byId.get().getLogin());
        assertThat(user.getPassword()).isNotEqualTo(byId.get().getPassword());
        assertThat(user.getAccountName()).isNotEqualTo(byId.get().getAccountName());
        assertThat(user.getAddressRegion()).isNotEqualTo(byId.get().getAddressRegion());
        assertThat(user.getAddressCity()).isNotEqualTo(byId.get().getAddressCity());
        assertThat(user.getAddressStreet()).isNotEqualTo(byId.get().getAddressStreet());
        assertThat(user.getAccountCreateDate()).isNotEqualTo(byId.get().getAccountCreateDate());
        assertThat(user.getAccountStatus()).isNotEqualTo(byId.get().getAccountStatus());

    }
}
