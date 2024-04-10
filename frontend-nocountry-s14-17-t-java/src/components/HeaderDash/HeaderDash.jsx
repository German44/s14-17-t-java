import { useNavigate, Link } from "react-router-dom";
import Logo from "../Logo/Logo";
import ButtonNeon from "../ButtonNeon/ButtonNeon";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";

const HeaderHome = () => {
  const { setAuth } = useContext(AuthContext);
  const navigate = useNavigate();

  const logout = () => {
    setAuth({});
    navigate("/login");
  };

  return (
    <div className="">
      <div className=" w-full h-[58px] flex justify-around items-center bg-black">
        <Link to="/">
          <Logo />
        </Link>
        <div className="w-auto h-auto flex items-center gap-2">
          <ButtonNeon text="Log Out" onClick={logout} />
        </div>
      </div>
    </div>
  );
};

export default HeaderHome;
