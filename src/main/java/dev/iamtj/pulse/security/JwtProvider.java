package dev.iamtj.pulse.security;

import dev.iamtj.pulse.exceptions.SpringPulseException;
import dev.iamtj.pulse.models.User;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Service
public class JwtProvider {


}
