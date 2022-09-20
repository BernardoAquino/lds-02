import { getGridSize } from "./grid"

const FONT_SIZES = {
  12: getGridSize(1.5),
  16: getGridSize(2),
  48: getGridSize(6)
}

const FONT_WEIGHTS = {
  normal: 400,
  regular: 500,
  bold: 600
}

const COLORS = {
  primary: {
    pure: '#ff0000',
    light: '#ff0001'
  },
  neutral: {
    0: '#000',
    75: '#ccc',
    100: '#fff'
  }
}

export const themeConfig = {
  grid: getGridSize,
  typography: {
    fontSize: FONT_SIZES,
    fontWeight: FONT_WEIGHTS,
  },
  color: COLORS,
}