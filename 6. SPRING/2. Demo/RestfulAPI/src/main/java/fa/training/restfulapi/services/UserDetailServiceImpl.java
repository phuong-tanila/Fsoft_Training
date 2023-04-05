package fa.training.restfulapi.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fa.training.restfulapi.cache.Cache;
import fa.training.restfulapi.entities.User;
import fa.training.restfulapi.repositories.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Cache cache;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) cache.getItem("user/" + username, User.class);
		if (user == null) {
			user = userRepository.findByEmail(username);
		}
		if (user == null) {
			throw new UsernameNotFoundException("No user found. Username tried: " + username);
		}
		cache.setItem("user/" + username, user);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("admin"));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				grantedAuthorities);
	}
}
