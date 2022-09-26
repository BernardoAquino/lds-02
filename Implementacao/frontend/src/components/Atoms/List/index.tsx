import React from 'react';

/** Style */
import * as El from './List.style';

export type ListProps = {
  columns?: number | number[];
  items: any[];
  render: Function;
}

const List = ({
  columns = 1,
  items,
  render
}: ListProps) => {
  return (
    <El.List columns={columns}>
      {items?.map((item: any, index: number) => (
        <El.Li>
          {render(item, index)}
        </El.Li>
      ))}
    </El.List>
  )
}

export default List;