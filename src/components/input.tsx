import { FC } from "react";


interface Props{
    placeholder:string;
}

const Input: FC<Props> = (props) => {
    const placeholder = props.placeholder;
    return (
        <div className="button2">
    <span></span>
    <span></span>
    <span></span>
    <span></span>
    <input type="transparent" placeholder={placeholder}/>
    
  </div>    
    
        
    
    )
}
export default Input;