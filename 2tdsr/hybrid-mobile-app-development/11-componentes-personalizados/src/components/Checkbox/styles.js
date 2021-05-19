import {StyleSheet} from 'react-native';

const styles = StyleSheet.create({
  containerCheck: {
    padding: 8,
    flexDirection: 'row',
    alignItems: 'center',
  },
  checkbox: {
    height: 14,
    width: 14,

    borderColor: '#ccc',
    borderWidth: 1,
    borderRadius: 5,

    marginRight: 8,
  },
  checkboxAtivo: {
    backgroundColor: '#0F0',
  },
  checkboxInativo: {
    backgroundColor: '#885',
  },
});

export default styles;
