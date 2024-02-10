package org.example.wimelody.services.inter;


import org.example.wimelody.entities.DBUser;
import org.example.wimelody.reqrsp.AuthenticationRequest;
import org.example.wimelody.reqrsp.AuthenticationResponse;
import org.example.wimelody.reqrsp.RegisterRequest;

public interface AuthenticationServiceInterface {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);

    DBUser getUser(String name);
}
