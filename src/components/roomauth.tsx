import { FC } from 'react'

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

const RoomAuthorization:FC<Props> = (props) => {
    const room= props.room;
    return (<div>
        <dialog id={`${room.id}`}>
            <form method="dialog">
                <p>Please enter password!</p>
                <menu className="dialog-menu">
                    <input type="password" name="password"/>
                    <button type="submit">Confirm</button>
                </menu>
            </form>
        </dialog>
        
        <dialog>
            <form method="dialog">
                <p>Invalid Password.</p>
                <menu className="dialog-menu">
                    <button>Okay</button>
                </menu>
            </form>
        </dialog>
    </div>)
}

export default RoomAuthorization;