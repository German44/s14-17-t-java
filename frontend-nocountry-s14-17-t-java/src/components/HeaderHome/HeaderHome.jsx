import Logo from "../Logo/Logo";
import ButtonNeon from "../ButtonNeon/ButtonNeon";
import { useNavigate, Link } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "../../context/AuthContext";

const HeaderHome = () => {
  const { logout } = useContext(AuthContext);
  const navigate = useNavigate();

  const handlerlogout = () => {
    logout();
    navigate("/login");
  };
  return (
    <div className="">
      <div className=" w-full h-[90px] flex justify-between pl-10 pr-10  items-center ">
        <Link to="/">
          <Logo/>
        </Link>
        <div className="flex gap-4">
          <ButtonNeon text="S14-17-t-Java" />
          <ButtonNeon text="Log Out" onClick={handlerlogout} />
        </div>
      </div>
    </div>
  );
};

export default HeaderHome;
