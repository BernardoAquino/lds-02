export const getGridValue = (size: number) => `${size * 8}px`;

export const theme = {
    typography: {
        fontSize: {
            8: getGridValue(1),
            12: getGridValue(1.5),
            14: getGridValue(1.75),
            16: getGridValue(2),
        }
    },
    colors: {
        brand: {
            light: '#76C04D',
            normal: '#007F76',
        },
        neutral: {
            0: '#ffffff',
            100: '#000000',
        }
    }
}