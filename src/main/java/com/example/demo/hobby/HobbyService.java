package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {
    public List<HobbyRequest> findHobbyAll() {
        return Store.hobbies;
    }

//    public Hobby findByHobbyId(Integer id) {
//        for (int i = 0; i < Store.hobbies.size(); i++) {
//            if(Store.hobbies.get(i).getId() == id)
//                return Store.hobbies.get(i);
//        }
//        return null;
//    }
    public void insertHobby(String name, Member member) {
        HobbyRequest hobbyRequest = new HobbyRequest();
        //맨처음에 가져왔던 member의 id를 가져옴
        hobbyRequest.setMemberId(member.getId());
        hobbyRequest.setName(name);

        //store에 추가
        Store.hobbies.add(hobbyRequest);

        //hobby가 insert 되자마자
        for (int i = 0; i < Store.members.size(); i++) {
            if(Store.members.get(i).getId() == member.getId())
                Store.members.get(i).getHobbies().add(hobbyRequest);
        }
    }
}
