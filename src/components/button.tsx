import { FC } from "react";


interface Props{
str:string;
}

const Button: FC<Props> = (props) => {
    const point:string = "179,1 179,59 1,59 1,1 179,1";
    const str=props.str;
    return (
    <div className="center">
        <button className="btn">
        <svg viewBox="0 0 180 60" width="180" height="60">
          <polyline points={point}/>
        </svg>
        <span>{str}</span>
      </button>
    </div>
    )
}
export default Button;