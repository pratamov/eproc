package id.noeandfriends.eproc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
