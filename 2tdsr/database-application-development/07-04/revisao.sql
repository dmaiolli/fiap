set serveroutput on

DECLARE
    CURSOR c_leitos_status_tipo IS SELECT
    TB_HOSPITAL.id_hospital, nome_hospital, ENDERECO, TELEFONE, 
    LEITOS_UTI.id_tipo_leito, descricao_TIPO, TB_STATUS.id_status, desc_status FROM TB_HOSPITAL 
    INNER JOIN LEITOS_UTI ON TB_HOSPITAL.id_hospital=LEITOS_UTI.id_hospital
    INNER JOIN TIPO_LEITO ON TIPO_LEITO.id_tipo_leito=LEITOS_UTI.id_itpo_leito
    INNER JOIN TB_STATUS ON TB_STATUS.id_status=LEITOS_UTI.id_status
    ORDER BY TB_HOSPTITAL.id_hospital, TB_STATUS.id_status, LEITOS_UTI.id_tipo_leito;
    
    V_LEITOS_STATUS_TIPO c_leitos_status_tipo%rowtype;
BEGIN
    OPEN C_leitos_status_tipo;
    LOOP
        FETCH C_leitos_status_tipo INTO V_LEITOS_STATUS_TIPO;
        EXIT WHEN C_leitos_status_tipo%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('No HOSPITAL' || V_LEITOS_STATUS_TIPO.id_hospital);
        DBMS_OUTPUT.PUT_LINE('NOME HOSPITAL' || V_LEITOS_STATUS_TIPO.nome_hospital);
        DBMS_OUTPUT.PUT_LINE('ENDERECO' || V_LEITOS_STATUS_TIPO.ENDERECO);
        DBMS_OUTPUT.PUT_LINE('TELEFONE' || V_LEITOS_STATUS_TIPO.TELEFONE);
        DBMS_OUTPUT.PUT_LINE('No TIPO LEITO' || V_LEITOS_STATUS_TIPO.id_tipo_leito);

    END LOOP;
END;