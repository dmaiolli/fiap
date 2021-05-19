import React from 'react';
import {Text, View, TouchableOpacity} from 'react-native';

import styles from './styles';

class Checkbox extends React.Component {
  state = {
    isChecked: this.props.checked,
  };

  pressionar() {
    const newChecked = !this.state.isChecked;

    this.setState({isChecked: newChecked});

    if (typeof this.props.onChecked === 'function') {
      this.props.onChecked(newChecked);
    }
  }

  render() {
    const quadrado = [styles.checkbox];

    if (this.state.isChecked) {
      quadrado.push(styles.checkboxAtivo);
    }

    return (
      <TouchableOpacity
        activeOpacity={0.6}
        style={styles.containerCheck}
        onPress={() => this.pressionar()}>
        <View style={quadrado} />
        <Text>{this.props.text || 'Texto default'}</Text>
      </TouchableOpacity>
    );
  }
}

export default Checkbox;
