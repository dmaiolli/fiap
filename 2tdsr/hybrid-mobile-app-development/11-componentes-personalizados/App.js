import React from 'react';
import {Button, SafeAreaView} from 'react-native';
import Checkbox from './src/components/Checkbox/Checkbox';

class App extends React.Component {
  state = {
    check01: false,
  };

  render() {
    return (
      <SafeAreaView>
        <Checkbox
          onChecked={status => this.setState({check01: status})}
          checked={this.state.check01}
          text="Texto 1"
        />
        <Checkbox text="Texto 2" />
        <Checkbox />

        <Button onPress={() => alert(this.state.check01)} title="Salvar" />
      </SafeAreaView>
    );
  }
}

export default App;
