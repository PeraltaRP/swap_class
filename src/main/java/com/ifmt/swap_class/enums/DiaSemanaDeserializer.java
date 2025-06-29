package com.ifmt.swap_class.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class DiaSemanaDeserializer extends JsonDeserializer<DiaSemana> {
    @Override
    public DiaSemana deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String nome = p.getText();
        return DiaSemana.fromNome(nome);
    }
}
