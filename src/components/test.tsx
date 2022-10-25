<div className="overflow-hidden">
      <div className="flex items-center justify-center h-screen overflow-y-auto bg-ice-8 opacity-90">
        {/* left square */}
        <div className="absolute top-0 rotate-45 -left-96 h-2/3 aspect-square bg-ice-3" />
        <div className="z-40 flex flex-col items-center justify-center gap-20 ">
          <div className="text-6xl font-bold text-white">Ice Breakers!</div>
          {/* center modal */}
          <div className="z-40 py-16 rounded-lg shadow-lg px-28 bg-ice-2">
            <div className="flex flex-row justify-start gap-10">
              <input
                className="justify-center text-xl font-bold text-center border rounded-md text-ice-7 px-14 bg-ice-0 border-ice-6"
                placeholder="Enter the room code"
              />
              <button>Join Room</button>
            </div>
          </div>
          <button>Create Game </button>
          {/* right square */}
          <div className="absolute bottom-0 rotate-45 -right-96 h-2/3 aspect-square bg-ice-3" />
        </div>
      </div>
    </div>