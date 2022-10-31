import { FC } from 'react';
import RoomAuthorization from './roomauth';
interface Props{
    room: Room
}

interface Room{
    id:number,
    game_id: number,
    name: string;
    has_password:boolean,
    no_users: number
}

const RoomListItem:FC<Props> = (props) => {
    const room= props.room;
    return (
        <div className={`roomListItem ${room.no_users < 6 ? 'open' : 'closed' }`}>
            <span>{room.name}</span>
            
            <span>
                {room.has_password} 
                <span className="roomListItem__players">PLAYERS {room.no_users}/6</span>
            </span>

            <RoomAuthorization room={room}/>
        </div>
    )
}

export default RoomListItem;