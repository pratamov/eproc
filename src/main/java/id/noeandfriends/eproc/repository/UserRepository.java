package id.noeandfriends.eproc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	public List<User> findByEmailAndPasswordAndUserType(String email, String password, int userType);
	public List<User> findByEmail(String email);
}
