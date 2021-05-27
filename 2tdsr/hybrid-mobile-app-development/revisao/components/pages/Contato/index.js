import React from 'react';
import {Button, ScrollView, StyleSheet, Text, TextInput} from 'react-native';

class Contato extends React.Component {
  render() {
    return (
      <ScrollView style={styles.page}>
        <Text>Nome:</Text>
        <TextInput style={styles.input} />

        <Text>Email:</Text>
        <TextInput style={styles.input} />

        <Text>Mensagem:</Text>
        <TextInput
          multiline={true}
          textAlignVertical="top"
          style={[styles.input, styles.textArea]}
        />

        <Button color="#489800" title="Enviar" />
      </ScrollView>
    );
  }
}

export default Contato;

const styles = StyleSheet.create({
  input: {
    borderColor: '#CCC',
    borderWidth: 1,
    borderRadius: 5,
    height: 30,
    marginBottom: 8,
  },
  textArea: {
    height: 150,
  },
  page: {
    padding: 16,
  },
});
