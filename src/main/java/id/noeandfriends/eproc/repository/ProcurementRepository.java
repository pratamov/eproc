package id.noeandfriends.eproc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.User;

public interface ProcurementRepository extends MongoRepository<Procurement, String>{
	List<Procurement> findByUser(User user);
}
