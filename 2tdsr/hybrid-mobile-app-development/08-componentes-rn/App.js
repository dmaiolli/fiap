/* eslint-disable react-native/no-inline-styles */
import React from 'react';
import {Text, View, StyleSheet, TextInput} from 'react-native';

class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text
          style={styles.texto}
          numberOfLines={1}
          ellipsizeMode="clip"
          selectable>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptates
          nihil quibusdam laboriosam aperiam perspiciatis aliquid harum rerum
          recusandae officia architecto at neque, ducimus velit natus eligendi,
          eius, necessitatibus nostrum pariatur!
        </Text>

        <TextInput
          style={styles.input}
          autoFocus
          placeholder="Olá"
          keyboardType="numeric"
          multiline={true}
          textAlignVertical="top"
          maxLength={15}
          editable={true}
          onFocus={() => alert('O campo recebeu foco!')}
        />

        <View style={styles.retangulo} />
        <View style={styles.retangulo} />
        <View style={styles.retangulo} />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#F00',
    flex: 1,
    padding: 30,
  },
  texto: {
    color: '#fff',
  },
  retangulo: {
    height: 100,
    width: 300,
    backgroundColor: '#333',
    borderRadius: 10,
    marginTop: 5,
  },
  input: {
    width: 300,
    height: 100,
    borderRadius: 8,
    backgroundColor: '#FFF',
    padding: 10,
  },
});

export default App;
