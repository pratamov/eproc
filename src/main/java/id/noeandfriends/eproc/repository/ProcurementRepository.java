package id.noeandfriends.eproc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.Procurement;

public interface ProcurementRepository extends MongoRepository<Procurement, String>{

}
